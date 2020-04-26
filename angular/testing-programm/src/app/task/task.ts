import { TaskType } from '../taskType/taskType';
import { Teacher } from '../teacher/teacher';
import { Subject } from '../subject/subject';

export class Task {
    id: number;
    name: string;
    description: string;
    uploader: Teacher;
    subject: Subject;
    type: TaskType;
    taskText: string;

    hasName(): boolean {
      if (this.name !== undefined) {
        return this.name.length !== 0;
      }
      return false;
    }

    hasText(): boolean {
      if (this.taskText !== undefined) {
        return this.taskText.length !== 0;
      }
      return false;
    }

    hasSubject(): boolean {
      if (this.subject !== undefined) {
        return this.subject.id !== undefined;
      }
      return false;
    }

    hasType(): boolean {
      if (this.type !== undefined) {
        return this.type.id !== undefined;
      }
      return false;
    }

    hasUploader(): boolean {
      if (this.uploader !== undefined) {
        return this.uploader.id !== undefined;
      }
      return false;
    }
}
