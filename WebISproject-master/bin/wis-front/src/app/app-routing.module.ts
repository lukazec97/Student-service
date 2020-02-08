import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AddStudentComponent} from './student/add-student/add-student.component';
import { GetStudentComponent } from './student/get-student/get-student.component';
import { EditStudentComponent } from './student/edit-student/edit-student.component';
import { SearchStudentComponent } from './student/search-student/search-student.component';
import {GetTeacherComponent} from './teachers/get-teacher/get-teacher.component';
import {EditTeacherComponent} from './teachers/edit-teacher/edit-teacher.component';
import {SearchTeacherComponent} from './teachers/search-teacher/search-teacher.component';
import { AddTeacherComponent } from './teachers/add-teacher/add-teacher.component';
import { LoginComponent } from './login/login.component';
import { HomePageComponent } from './home-page/home-page.component';
import { CenterComponent } from './centers/center/center.component';
import { StudyProgramComponent } from './studyPrograms/study-program/study-program.component';
import { CreateCenterComponent } from './centers/create-center/create-center.component';
import { CreateSpComponent } from './studyPrograms/create-study-program/create-sp.component';
import { RegisterComponent } from './register/register.component';
import { WebsocketComponent } from './websocket/websocket.component';
import { CreateYearOfStudyComponent } from './yearOfstudy/create-year-of-study/create-year-of-study.component';
import { CreateCourseComponent } from './courses/create-course/create-course.component';
import { CourseMaterialPageComponent } from './course-material-page/course-material-page.component';
import { DragAndDropComponent } from './drag-and-drop/drag-and-drop.component';
import { AuthGuardService } from './auth-guard.service';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';

const routes: Routes = [
  {path: 'user-dashboard/student/add', component: AddStudentComponent, canActivate: [AuthGuardService]},
  {path: 'user-dashboard/students', component: GetStudentComponent, canActivate: [AuthGuardService]},
  {path: 'user-dashboard/students/:id', component: EditStudentComponent, canActivate: [AuthGuardService]},
  {path: 'user-dashboard/findStudentByFirstName', component: SearchStudentComponent},
  {path: 'login', component: LoginComponent},
  {path: 'user-dashboard/teacher/add', component: AddTeacherComponent, canActivate: [AuthGuardService]},
  {path: 'user-dashboard/teacher/:id', component: EditTeacherComponent, canActivate: [AuthGuardService]},
  {path: 'user-dashboard/teacher', component: GetTeacherComponent, canActivate: [AuthGuardService]},
  {path: 'user-dashboard/findTeacherByFirstName', component: SearchTeacherComponent},
  {path: '', component: HomePageComponent},
  {path: 'center', component: CenterComponent},
  {path: 'center/studyPrograms', component: StudyProgramComponent},
  {path: 'user-dashboard/createCenter', component: CreateCenterComponent, canActivate: [AuthGuardService]},
  {path: 'user-dashboard/createSp', component: CreateSpComponent, canActivate: [AuthGuardService]},
  {path: 'user-dashboard/register', component: RegisterComponent, canActivate: [AuthGuardService]},
  {path: 'chat', component: WebsocketComponent},
  {path: 'user-dashboard/createYos', component: CreateYearOfStudyComponent, canActivate: [AuthGuardService]},
  {path: 'user-dashboard/createCourse', component: CreateCourseComponent, canActivate: [AuthGuardService]},
  {path: 'user-dashboard/courseMaterialPage', component: CourseMaterialPageComponent},
  {path: 'user-dashboard', component: UserDashboardComponent},
  {path: 'dragAndDrop', component: DragAndDropComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {onSameUrlNavigation: "reload"})],
  exports: [RouterModule],
  providers: [AuthGuardService]
})
export class AppRoutingModule { }
