import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {AddStudentComponent} from './student/add-student/add-student.component';
import { SlimLoadingBarModule } from 'ng2-slim-loading-bar';
import { ReactiveFormsModule } from '@angular/forms';
import { OrderModule } from 'ngx-order-pipe';

import { StudentService } from './student/student.service';
import { GetStudentComponent } from './student/get-student/get-student.component';
import { EditStudentComponent } from './student/edit-student/edit-student.component';
import { SearchStudentComponent } from './student/search-student/search-student.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { MyHttpInterceptor } from './interceptor';
import { SearchTeacherComponent } from './teachers/search-teacher/search-teacher.component';
import { GetTeacherComponent } from './teachers/get-teacher/get-teacher.component';
import { AddTeacherComponent } from './teachers/add-teacher/add-teacher.component';
import { LoginComponent } from './login/login.component';
import { EditTeacherComponent } from './teachers/edit-teacher/edit-teacher.component';
import { FooterComponent } from './footer/footer.component';
import { ModalBasicComponent } from './modal-basic/modal-basic.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HomePageComponent } from './home-page/home-page.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AgmCoreModule } from '@agm/core';
import { CenterComponent } from './centers/center/center.component';
import { StudyProgramComponent } from './studyPrograms/study-program/study-program.component';
import { CreateCenterComponent } from './centers/create-center/create-center.component';
import { CreateSpComponent } from './studyPrograms/create-study-program/create-sp.component';
import { RegisterComponent } from './register/register.component';
import { WebsocketComponent } from './websocket/websocket.component';
import {CreateYearOfStudyComponent} from './yearOfstudy/create-year-of-study/create-year-of-study.component';
import { CreateCourseComponent } from './courses/create-course/create-course.component';
import { CourseMaterialPageComponent } from './course-material-page/course-material-page.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DragAndDropComponent } from './drag-and-drop/drag-and-drop.component';
import { DragDropModule } from '@angular/cdk/drag-drop';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { EnrollStudentComponent } from './student/enroll-student/enroll-student.component';
import { EnrollNextComponent } from './student/enroll-next/enroll-next.component';


@NgModule({
  declarations: [
    AppComponent,
    AddStudentComponent,
    GetStudentComponent,
    EditStudentComponent,
    SearchStudentComponent,
    SearchTeacherComponent,
    GetTeacherComponent,
    AddTeacherComponent,
    LoginComponent,
    EditTeacherComponent,
    FooterComponent,
    ModalBasicComponent,
    HomePageComponent,
    NavbarComponent,
    CenterComponent,
    StudyProgramComponent,
    CreateCenterComponent,
    CreateSpComponent,
    RegisterComponent,
    WebsocketComponent,
    CreateYearOfStudyComponent,
    CreateCourseComponent,
    CourseMaterialPageComponent,
    UserDashboardComponent,
    DragAndDropComponent,
    UserDashboardComponent,
    EnrollStudentComponent,
    EnrollNextComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SlimLoadingBarModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
    NgbModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyB2qilSTZvWZFo1puwcpU3qHH-_bnN8DyQ'
    }),
    OrderModule,
    BrowserAnimationsModule,
    DragDropModule
  ],
  providers: [StudentService, {
    provide: HTTP_INTERCEPTORS,
    useClass: MyHttpInterceptor,
    multi: true
  }],
  bootstrap: [AppComponent, ModalBasicComponent],
  exports: [ModalBasicComponent]
})
export class AppModule { }
