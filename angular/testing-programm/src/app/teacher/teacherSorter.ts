import { Teacher } from './teacher';

export class TeacherSorter {

    sortByName(teachers: Array<Teacher>) {
        teachers.sort(
            (first, second) => (first.name > second.name ? 1 : -1)
        );
    }

    sortBySurname(teachers: Array<Teacher>) {
        teachers.sort(
            (first, second) => (first.surname > second.surname ? 1 : -1)
        );
    }

    sortByLogin(teachers: Array<Teacher>) {
        teachers.sort(
            (first, second) => (first.login > second.login ? 1 : -1)
        );
    }
}
