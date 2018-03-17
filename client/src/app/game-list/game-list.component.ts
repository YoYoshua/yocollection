import { Component, OnInit } from '@angular/core';
import {GameService} from '../shared/game/game.service';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-game-list',
  templateUrl: './game-list.component.html',
  styleUrls: ['./game-list.component.scss']
})
export class GameListComponent implements OnInit {
  games: Array<any>;
  searchGame: any = {};

  constructor(private gameService: GameService) { }

  ngOnInit() {
    this.gameService.getAll().subscribe( data => {
      this.games = data;
      console.log(data);
    });
  }

  showAll() {
    this.gameService.getAll().subscribe(data => {
      this.games = data;
    })
  }

  search(form: NgForm) {
    this.gameService.search(form).subscribe(data => {
      this.games = data;
      console.log(data);
    });
  }

  getIterator(number: number): Iterable<any> {
    let result = new Array<number>;
    for(let i = number - 1; i >= 0; i--) {
      result[i] = [1];
    }
    console.log(result);
    return result;
  }

}
