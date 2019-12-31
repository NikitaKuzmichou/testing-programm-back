import { TaskType } from "../taskType/taskType";
import { Teacher } from "../teacher/teacher";
import { Subject } from "../subject/subject";

export class Task {
    id: number;
    name: string;
    description: String;
    uploader: Teacher;
    subject: Subject;
    taskType: TaskType;
    taskText: String;
}
