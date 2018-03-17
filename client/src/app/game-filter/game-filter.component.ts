import { Component, OnInit } from '@angular/core';
import {PlatformService} from '../shared/platform/platform.service';

@Component({
  selector: 'app-game-filter',
  templateUrl: './game-filter.component.html',
  styleUrls: ['./game-filter.component.scss']
})
export class GameFilterComponent implements OnInit {
  platforms: Array<any>;

  constructor(private platformService: PlatformService) { }

  ngOnInit() {
    this.platformService.getAll().subscribe(data => {
      this.platforms = data;
      console.log(data);
    });
  }

}
