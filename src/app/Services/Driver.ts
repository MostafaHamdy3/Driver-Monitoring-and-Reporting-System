export class Driver {
    id?: string;
    firstName?: string;
    lastName?: string;
    gender?: Gender;
    phone?: string;
    email?: string;
    password?: string;
    jobTitle?: string;
    imgURL?: string;
    age?: number;
    score?: number;
}

enum Gender{
    Male,Female
}

