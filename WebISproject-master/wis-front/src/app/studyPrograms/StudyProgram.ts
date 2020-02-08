import YearOfStudy from '../yearOfstudy/YearOfStudy';
import Center from '../centers/Center';

export default class StudyProgram {
    id: number;
    name: string;
    yearsOfStudy: YearOfStudy[];
    center: Center = new Center();
    pic: Int8Array;
    mimetype: string;
}