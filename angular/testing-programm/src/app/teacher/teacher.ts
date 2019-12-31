import { Role } from "../role/role";

export class Teacher {
    id: number;
    name: string;
    surname: string;
    patronymic: string;
    login: string;
    password: string;
    role: Role;
}