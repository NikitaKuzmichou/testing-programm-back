import { Pupil } from '../pupil/pupil';
import { Attempt } from '../attempt/attempt';
import { Mistake } from '../mistake/mistake';

export class PupilAttempt {
    id: number;
    pupil: Pupil;
    attempt: Attempt;
    mistakes: Mistake[] = new Array<Mistake>();
    text: string;
    mark: number;
}
