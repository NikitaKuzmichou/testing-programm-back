import { Group } from "../group/group";
import { Role }  from "../role/role";

export class Pupil {
    id: number;
    name: string;
    surname: string;
    patronymic: string;
    login: string;
    password: string;
    role: Role;
    group: Group;
}