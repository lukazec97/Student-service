import StudyProgram from '../studyPrograms/StudyProgram';

export default class Center {
    id: number;
    name: string;
    studyPrograms: StudyProgram[];
    pic: Int8Array;
    mimetype: string;
}