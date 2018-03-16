import { Component, OnInit } from '@angular/core';
import {GameService} from '../shared/game.service';

@Component({
  selector: 'app-game-list',
  templateUrl: './game-list.component.html',
  styleUrls: ['./game-list.component.scss']
})
export class GameListComponent implements OnInit {
  games: Array<any>;

  constructor(private gameService: GameService) { }

  ngOnInit() {
    this.gameService.getAll().subscribe( data => {
      this.games = data;
      console.log(data);
    });
  }

}
