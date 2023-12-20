export class Driver {
    id!: string;
    firstName!: string;
    lastName!: string;
    gender!: Gender;
    phone!: string;
    email!: string;
    password!: string;
    jobTitle!: string;
    imgURL!: string;
    age!: number;
    score!: number;

    // constructor(id: string, firstName: string, lastName: string, gender: Gender, phone: string, email: string, password: string, jobTitle: string, imgURL: string, age: number, score: number) {
    //     this.id = id;
    //     this.firstName = firstName;
    //     this.lastName = lastName;
    //     this.gender = gender;
    //     this.phone = phone;
    //     this.email = email;
    //     this.password = password;
    //     this.jobTitle = jobTitle;
    //     this.imgURL = imgURL;
    //     this.age = age;
    //     this.score = score;
    // }

}

enum Gender{
    Male,Female
}

