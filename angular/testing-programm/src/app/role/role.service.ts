import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Role } from './role';

@Injectable({
    providedIn: 'root'
}) export class RoleService {
    private url: string;
    constructor(private http: HttpClient) {}

    setUrl(url: string) {
        this.url = url;
    }

    getRole(id: number): Role {
        const response = this.http.get<Role>(this.url + '/' + id);
        return this.parseToRole(response);
    }

    getRoleByName(name: string): Role {
        const response = this.http.get<Role>(this.url + '/' + name);
        return this.parseToRole(response);
    }

    getRoles(): Array<Role> {
        const response = this.http.get<Array<Role>>(this.url);
        return this.parseToListRoles(response);
    }

    updateRole(role: Role) {
        const response = this.http.put<Role>(this.url, role);
        return this.parseToRole(response);
    }

    saveRole(role: Role) {
        const response = this.http.post<Role>(this.url, role);
        return this.parseToRole(response);
    }

    deleteRole(id: number) {
        let response;
        this.http.delete(this.url + "/" + id).subscribe(item => {
            response = item;
        }, error => {
            console.error(error);
        });
        return response;
    }

    private parseToRole(observable: Observable<Role>): Role {
        let role = new Role();
        observable.subscribe(item => {
            role.id = item.id;
            role.name = item.name;
        }, error => {
            console.error(error);
        });
        return role;
    }

    private parseToListRoles(observable: Observable<Array<Role>>): Array<Role> {
        let roles = new Array<Role>();
        observable.subscribe(response => {
            response.map(item => {
                let role = new Role();
                role.id = item.id;
                role.name = item.name;
                roles.push(role);
            });
        }, error => {
            console.error(error);
        });
        return roles;
    }
}
