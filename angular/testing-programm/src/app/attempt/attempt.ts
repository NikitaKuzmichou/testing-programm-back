import { Task } from "../task/task";
import { PupilAttempt } from "../pupil-attempt/pupilAttempt";

export class Attempt {
    id: number;
    pupilsAttempts: PupilAttempt[] = new Array<PupilAttempt>();
    task: Task;
    start: number;
    end: number;
}