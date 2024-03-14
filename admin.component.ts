import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-admin',
  standalone: true,
  imports: [FormsModule,RouterOutlet,CommonModule],
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css'
})
export class AdminComponent {
username:string="";
password:string="";
constructor(private router :Router){
}
validate()
{
  console.log("validate is called");
  if(this.username=='admin'&& this.password=='admin123')
  {
    this.router.navigate(['exam']);
  }
}

}
