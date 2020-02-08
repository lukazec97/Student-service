import StudyProgram from '../studyPrograms/StudyProgram';

export default class YearOfStudy {
    id: number;
    numberOfYear: string;
    title: string;
    studyProgram: StudyProgram = new StudyProgram();
}