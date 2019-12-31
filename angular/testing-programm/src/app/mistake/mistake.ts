import { PupilAttempt } from "../pupil-attempt/pupilAttempt";
import { Rule } from '../rule/rule';

export class Mistake {
    id: number;
    pupilAttempt: PupilAttempt;
    rule: Rule;
    rowNo: number;
    colNo: number;
}