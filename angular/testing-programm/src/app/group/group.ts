import { Pupil } from "../pupil/pupil";

export class Group {
    id: number;
    groupNo: number;
    faculty: string;
    cource: number;
    pupils: Pupil[] = new Array<Pupil>();
}