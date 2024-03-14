import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { TitlePipe } from '../title.pipe';

@Component({
  selector: 'app-welcome',
  standalone: true,
  imports: [CommonModule,TitlePipe],
  templateUrl: './welcome.component.html',
  styleUrl: './welcome.component.css'
})
export class WelcomeComponent implements OnInit {
username:any="";
imgurl:string="assets/images/one.png";
birthdate:Date=new Date(2024,0,24);
ngOnInit(): void {
  this.username=sessionStorage.getItem('username');
}
show :boolean=false;
persons:any[]=[
  {name:'sachin',country:'india'},
  {name:'mac',country:'america'},
  {name:'zen',country:'france'},
  {name:'mahesh',country:'india'},
]
getColor(countryname:string)
{
  switch(countryname)
  {
    case 'india':
      return 'green';
      case 'america':
      return 'red';
      case 'france':
      return 'blue';
  }
  return "grey";
}
}
