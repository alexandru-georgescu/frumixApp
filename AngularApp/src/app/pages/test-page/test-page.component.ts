import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/user';
import { UserService } from 'src/app/user-service.service';

@Component({
  selector: 'app-test-page',
  templateUrl: './test-page.component.html',
  styleUrls: ['./test-page.component.css']
})
export class TestPageComponent implements OnInit {

  users: User[];
 
  constructor(private userService: UserService) {
  }
 
  ngOnInit() {
    this.userService.findAll().subscribe(data => {
      this.users = data;
    });
  }

}