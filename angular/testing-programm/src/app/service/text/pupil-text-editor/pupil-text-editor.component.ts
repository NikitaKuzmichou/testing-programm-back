import { Component, OnInit } from '@angular/core';
import { Input, Output } from '@angular/core';
import { EventEmitter } from '@angular/core';
import { Mistake } from '../../../mistake/mistake';
import { MistakesSorting } from '../../sorting/MistakesSorting';
import { MistakeService } from '../../../mistake/mistake.service';
import { ServerRequestUrls } from '../../../ServerRequestUrls';
import { MistakeElement } from './MistakeElement';

@Component({
  selector: 'app-pupil-text-editor',
  templateUrl: './pupil-text-editor.component.html',
  styleUrls: ['./pupil-text-editor.component.css']
})
export class PupilTextEditorComponent implements OnInit {
  @Input() pupilText: string[];
  @Input() allMistakes: Array<Mistake>;
  @Input() mark: number;
  @Output() outMistakes = new EventEmitter<Mistake[]>();
  private start = 0;
  private end = 0;
  private isTextSet = false;

  constructor(private mistakeService: MistakeService) {
    mistakeService.setUrl(ServerRequestUrls.MISTAKE);
  }

  ngOnInit(): void {
    this.allMistakes = this.sortMistakes(this.allMistakes);
  }

  setPupilText() {
    /*if delete this the text is displayed multiple times*/
    if (!this.isTextSet) {
      this.isTextSet = true;
      let pupilTextElement = '';
      const mistakeElement = new MistakeElement();
      let wordNo;
      for (wordNo = 0; wordNo < this.pupilText.length; ++wordNo) {
       if (this.hasMistake(wordNo)) {
         pupilTextElement += mistakeElement.generateMistakeElement(
           this.pupilText[wordNo], this.getWordMistakes(wordNo));
         this.start = this.end;
       } else {
         pupilTextElement += this.pupilText[wordNo] + ' ';
       }
      }
      document.getElementById('pupil-text')
              .insertAdjacentHTML('beforeend', pupilTextElement);
    }
  }

  getNumMistakes() {
    return this.allMistakes ? this.allMistakes.length : 0;
  }

  getMark() {
    return this.mark ? this.mark : 'Не выставлена';
  }

  private sortMistakes(mistakes: Mistake[]) {
    const sorter = new MistakesSorting();
    return sorter.sort(mistakes);
  }

  private getWordMistakes(wordNo: number) {
    while (this.end < this.allMistakes.length && this.allMistakes[this.end].wordNo === wordNo) {
      ++this.end;
    }
    return this.allMistakes.slice(this.start, this.end);
  }

  private hasMistake(wordNo: number) {
    return this.start < this.allMistakes.length ?
           this.allMistakes[this.start].wordNo === wordNo : false;
  }
}
