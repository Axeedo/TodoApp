import { booleanAttribute, Component, input } from '@angular/core';
import { Observable } from 'rxjs';
import { Task } from '../services/task.service';

@Component({
  selector: 'app-task-list',
  imports: [],
  templateUrl: './task-list.component.html',
  styleUrl: './task-list.component.css',
})
export class TaskListComponent {
  isDoneStatus = input.required<boolean>();
  tasks: Observable<Task[]>;
  ngOnInit() {
    this.tasks = this.taskService.getTasks();
  }
}
