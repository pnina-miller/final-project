import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User, Result } from './User.model';
import { parseSelectorToR3Selector } from '@angular/compiler/src/core';

@Injectable()
export class EasyService {
    constructor(private _http: HttpClient) {

    }

    getAllUsersFromServer(): Observable<User[]> {

        return this._http.get<User[]>("/api/Users/ggg/123");

    }
    getUserFromServer(email, password): Observable<Result> {
        console.log("getUserFromServer")

        return this._http.post<Result>("http://localhost:8080/test/user/GetUser?email=" + email, password);

    }
    postUser(user: User): Observable<boolean> {
        console.log(user)
        return this._http.get<boolean>("http://localhost:8080/test/user/byId?id="+1003);
        // return this._http.post<boolean>("http://localhost:8080/test/user", { email: user.email, password: user.password });
    }
    // saveChanges2(v:Valanteer):Observable<boolean>{
    //         return this._http.put<boolean>("/api/Schesuling?v=",v);
    //      }
    // getScheduling():Observable<Valanteer[]>{
    //         return this._http.get<Valanteer[]>("/api/Schesuling");
    //     }

    // saveChanges(id:number,days:boolean[]):Observable<boolean>{
    //    return this._http.put<boolean>("/api/valanteer",id);
    // }
}