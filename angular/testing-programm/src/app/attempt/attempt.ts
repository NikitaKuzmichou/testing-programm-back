import { Task } from "../task/task";
import { PupilAttempt } from "../pupil-attempt/pupilAttempt";

export class Attempt {
    id: number;
    pupilAttempts: PupilAttempt[] = new Array<PupilAttempt>();
    task: Task;
    start: Date;
    end: Date;
}