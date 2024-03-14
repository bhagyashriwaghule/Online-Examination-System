import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { UserComponent } from './user/user.component';
import { ComboboxComponent } from './combobox/combobox.component';
import { QuestionComponent } from './question/question.component';
import { ScoreComponent } from './score/score.component';
import { AdminComponent } from './admin/admin.component';
import { TimeComponent } from './time/time.component';
import { QuestionmanagementComponent } from './questionmanagement/questionmanagement.component';
import { ExamComponent } from './exam/exam.component';

export const routes: Routes = [

{path:'login',component:LoginComponent},
{ path:"welcome",component:WelcomeComponent},
{path:'register',component:UserComponent},
{path:'comboboxex',component:ComboboxComponent},
{path:'question',component:QuestionComponent},
{path:'score',component:ScoreComponent},
{path:'admin',component:AdminComponent},
{path:'time',component:TimeComponent},
{path:'questionmanagement',component:QuestionmanagementComponent},
{path:'exam',component:ExamComponent},
];
