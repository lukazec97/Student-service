import YearOfStudy from '../yearOfstudy/YearOfStudy';

export default class Course {
    id: number;
    title: string;
    yearOfStudy: YearOfStudy = new YearOfStudy();
}