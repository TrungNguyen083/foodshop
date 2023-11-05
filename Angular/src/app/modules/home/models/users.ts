export class Users {
    id?:string;
    fullName?:String;
    username?:String;
    email?:String;
    password?:String;
    address?:string;
    
  constructor(
    id: any, 
    fullName: any, 
    username: any, 
    email: any, 
    password: any, 
    address: any
) {
    this.id = id;
    this.fullName = fullName;
    this.username = username;
    this.email = email;
    this.password = password;
    this.address = address;
  }    

}
