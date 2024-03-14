import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpclient:HttpClient) { }
  saveUser(user:User)
  {
    return this.httpclient.post<void>("http://localhost:8080/saveUser",user);
  }
  getAllUsers()
  {
  return  this.httpclient.get<User[]>("http://localhost:8080/getAllUsers");
  }
  getUser(username:string)
  {
    return this.httpclient.get<User>("http://localhost:8080/getUser/" +username);
  }
  deleteUser(username:string)
  {
    return this.httpclient.delete<boolean>("http://localhost:8080/deleteUser/"+ username);
  }
}
export class User{

username:string;
password:string;
mobno:number;
emailid:string;
public constructor(username:string,password:string,mobno:number,emailid:string)
{
  this.username=username;
  this.password=password;
  this.mobno=mobno;
  this.emailid=emailid;
}
}