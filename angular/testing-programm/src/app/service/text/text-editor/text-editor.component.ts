import { Component, OnInit } from '@angular/core';
import { Input, Output } from '@angular/core';
import { EventEmitter } from '@angular/core';

@Component({
  selector: 'app-text-editor',
  templateUrl: './text-editor.component.html',
  styleUrls: ['./text-editor.component.css']
})
export class TextEditorComponent implements OnInit {
  @Input() initialText: string;
  @Input() disabled: boolean;
  @Output() outText = new EventEmitter<string>();

  constructor() {}

  ngOnInit(): void {
  }

  isDisabled() {
    return this.disabled;
  }

  update() {
    this.outText.emit(this.initialText);
  }
}
