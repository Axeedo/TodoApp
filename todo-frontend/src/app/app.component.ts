import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MatTabsModule } from '@angular/material/tabs';
import { TaskListComponent } from './task-list/task-list.component';
@Component({
  selector: 'app-root',
  imports: [RouterOutlet, MatTabsModule, TaskListComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {}
