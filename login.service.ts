import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './user.service';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private httpclient:HttpClient) { }
  validateUser(user:User):Observable<boolean>
  {
    return this.httpclient.post<boolean>("http://localhost:8080/validate",user);
  }
}
