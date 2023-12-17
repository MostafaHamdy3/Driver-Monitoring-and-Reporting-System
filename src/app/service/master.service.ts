import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MasterService {

  constructor(private http:HttpClient) { }
  listarray = [{ "name": "ravi", "mark": "75" }]
  GetData() {
    return this.listarray;
  }
  SaveData(input: any) {
    this.listarray.push(input);
  }

  GetEmployee(){
   let token='eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1bmlxdWVfbmFtZSI6ImFkbWludXNlciIsInJvbGUiOiJhZG1pbiIsIm5iZiI6MTY2MTgzOTg1NiwiZXhwIjoxNjYxODQxMDU2LCJpYXQiOjE2NjE4Mzk4NTZ9.UH-ANZN90QYmi8mUfnySLbfdCfMuSBnsKycAMqsgUPg'
    let head_obj=new HttpHeaders().set("Authorization","bearer "+token)
    return this.http.get("https://localhost:44308/Employee",{headers:head_obj});
  }

  GetCustomer(){
    return this.http.get("https://localhost:44308/Customer");
  }

  Getchartinfo(){
    return this.http.get("http://localhost:3000/sales");
  }
}
