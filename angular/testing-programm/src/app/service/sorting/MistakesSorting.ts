import { Mistake } from '../../mistake/mistake';
import { MistakeSortingCriteria } from './MistakeSortingCriteria';

export class MistakesSorting {

  sort(mistakes: Mistake[]) {
    mistakes = this.sortByWordNo(mistakes);
    mistakes = this.sortBySymbolNo(mistakes);
    return mistakes;
  }

  private sortByWordNo(mistakes: Mistake[]) {
    return this.quickSort(mistakes, MistakeSortingCriteria.WORD_NO);
  }

  private sortBySymbolNo(mistakes: Mistake[]) {
    let begin = 0;
    let end = 0;
    while (end < mistakes.length) {
      while (end < mistakes.length && mistakes[end].wordNo === mistakes[begin].wordNo) {
        ++end;
      }
      mistakes = this.quickSort(mistakes, MistakeSortingCriteria.SYMBOL_NO, begin, end - 1);
      begin = end;
    }
    return mistakes;
  }

  private quickSort(mistakes: Mistake[], criteria: MistakeSortingCriteria,
                    left: number = 0, right: number = mistakes.length - 1) {
    if (mistakes.length > 1) {
      const pivot = mistakes[Math.floor(left + (right - left) / 2)];
      let l = left;
      let r = right;
      while (l <= r) {
        if (criteria === MistakeSortingCriteria.WORD_NO) {
          l = this.getLeftByWordNo(mistakes, pivot, l);
          r = this.getRightByWordNo(mistakes, pivot, r);
        }
        if (criteria === MistakeSortingCriteria.SYMBOL_NO) {
          l = this.getLeftBySymbolNo(mistakes, pivot, l);
          r = this.getRightBySymbolNo(mistakes, pivot, r);
        }
        if (l <= r) {
          [mistakes[l], mistakes[r]] = [mistakes[r], mistakes[l]];
          ++l;
          --r;
        }
      }
      if (left < r) {
        this.quickSort(mistakes, criteria, left, r + 1);
      }
      if (l < right) {
        this.quickSort(mistakes, criteria, l, right);
      }
    }
    return mistakes;
  }

  private getLeftByWordNo(mistakes: Mistake[], pivot: Mistake, left: number) {
    while (mistakes[left].wordNo < pivot.wordNo) {
      ++left;
    }
    return left;
  }

  private getRightByWordNo(mistakes: Mistake[], pivot: Mistake, right: number) {
    while (mistakes[right].wordNo > pivot.wordNo) {
      --right;
    }
    return right;
  }

  private getLeftBySymbolNo(mistakes: Mistake[], pivot: Mistake, left: number) {
    while (mistakes[left].symbolNo < pivot.symbolNo) {
      ++left;
    }
    return left;
  }

  private getRightBySymbolNo(mistakes: Mistake[], pivot: Mistake, right: number) {
    while (mistakes[right].symbolNo > pivot.symbolNo) {
      --right;
    }
    return right;
  }
}
