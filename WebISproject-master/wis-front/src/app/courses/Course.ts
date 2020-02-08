import YearOfStudy from 'src/app/yearOfstudy/YearOfStudy';

export default class Course {
    id: number;
    title: string;
    yearOfStudy: YearOfStudy = new YearOfStudy();
    pic: Int8Array;
    mimetype: string;
}