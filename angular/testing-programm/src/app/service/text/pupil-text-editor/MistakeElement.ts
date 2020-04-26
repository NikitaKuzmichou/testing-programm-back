import { Mistake } from '../../../mistake/mistake';

export class MistakeElement {
  generateMistakeElement(word: string, mistakes: Mistake[]) {
    let element = '';
    let i;
    for (i = 0; i < mistakes.length; ++i) {
      element += this.getBeforeMistake(word, mistakes[i], i === 0 ? null : mistakes[i - 1]);
      if (mistakes[i].rule) {
        element += this.getMistakeWithRule(word, mistakes[i]);
      } else {
        element += this.getMistakeWithoutRule(word, mistakes[i]);
      }
    }
    element += this.getAfterMistakes(word, mistakes[mistakes.length - 1]);
    element += ' ';
    return element;
  }

  private getBeforeMistake(word: string, mistake: Mistake, prevMistake: Mistake) {
    if (prevMistake) {
      return word.substr(prevMistake.symbolNo + 1, mistake.symbolNo);
    } else {
      return word.substr(0, mistake.symbolNo);
    }
  }

  private getMistakeWithRule(word: string, mistake: Mistake) {
    let info = '<span class="bg-danger">';
    info += '<a routerLink="/rules/' + mistake.rule.id + 'placement="top" ' +
      'ngbTooltip="' + mistake.rule.description + '"';
    info += word.substr(mistake.symbolNo, mistake.symbolNo + 1);
    info += '</a>';
    info += '</span>';
    return info;
  }

  private getMistakeWithoutRule(word: string, mistake: Mistake) {
    let info = '<span class="bg-danger">';
    info += word.substr(mistake.symbolNo, mistake.symbolNo + 1);
    info += '</span>';
    return info;
  }

  private getAfterMistakes(word: string, mistake: Mistake) {
    return word.substr(mistake.symbolNo + 1, word.length);
  }
}
