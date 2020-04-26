import { Group } from '../group/group';
import { Role } from '../role/role';

export class Pupil {
    id: number;
    name: string;
    surname: string;
    patronymic: string;
    login: string;
    password: string;
    role: Role;
    group: Group;

    getFullName() {
        let name = this.surname + ' ' + this.name;
        if (this.hasPatronymic()) {
            name += ' ' + this.patronymic;
        }
        return name;
    }

    hasName(): boolean {
        if (this.name !== undefined) {
          return this.name.length !== 0;
        }
        return false;
    }

    hasSurname(): boolean {
        if (this.surname !== undefined) {
            return this.surname.length !== 0;
        }
        return false;
    }

    hasPatronymic() {
        if (this.patronymic !== undefined) {
            return this.patronymic.length !== 0;
        }
        return false;
    }

    hasLogin(): boolean {
        if (this.login !== undefined) {
            return this.login.length !== 0;
        }
        return false;
    }

    hasPassword(): boolean {
        if (this.password !== undefined) {
            return this.password.length !== 0;
        }
        return false;
    }

    hasGroup(): boolean {
        if (this.group !== undefined) {
            return this.group.id !== undefined;
        }
        return false;
    }
}
