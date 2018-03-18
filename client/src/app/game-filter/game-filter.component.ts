import { Component, OnInit } from '@angular/core';
import {PlatformService} from '../shared/platform/platform.service';
import {GameService} from '../shared/game/game.service';

@Component({
  selector: 'app-game-filter',
  templateUrl: './game-filter.component.html',
  styleUrls: ['./game-filter.component.scss']
})
export class GameFilterComponent implements OnInit {
  platforms: Array<any>;

  constructor(private platformService: PlatformService,
              private gameService: GameService) { }

  ngOnInit() {
    this.platformService.getAll().subscribe(data => {
      this.platforms = data;
      console.log(data);
    });
  }

  changePlatformFilter(button: String) {
    this.gameService.filterByPlatform(button);

  }

  changeRatingMinFilter(button: String) {
    this.gameService.filterByMinRating(button);
  }

  changeRatingMaxFilter(button: String) {
    this.gameService.filterByMaxRating(button);

  }

  resetAll() {
    this.changePlatformFilter('0');
    this.changeRatingMinFilter('0');
    this.changeRatingMaxFilter('5');
  }

}
