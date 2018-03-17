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
  sortBy: String;
  orderBy: String;

  constructor(private gameService: GameService) { }

  ngOnInit() {
    this.sortBy = 'Name';
    this.orderBy = 'Ascending';
    this.gameService.getAll().subscribe( data => {
      this.games = data;
      console.log(data);
    });
  }

  showAll() {
    this.gameService.getAll().subscribe(data => {
      this.games = data;
    });
  }

  search(form: NgForm) {
    this.gameService.search(form).subscribe(data => {
      this.games = data;
      console.log(data);
    });
  }

  getIterator(number: number): Iterable<any> {
    const result = new Array<number>();
    for (let i = number - 1; i >= 0; i--) {
      result[i] = 1;
    }
    return result;
  }

  changeSort(button: number) {
    switch (button) {
      case 1:
        this.sortBy = 'Name';
        break;
      case 2:
        this.sortBy = 'Platform';
        break;
      case 3:
        this.sortBy = 'Rating';
        break;
      default:
        this.sortBy = 'Name';
        break;
    }

    this.gameService.sortBy(this.sortBy).subscribe(data => {
      this.games = data;
    });
  }

  changeOrder(button: number) {
    switch (button) {
      case 1:
        this.orderBy = 'Ascending';
        break;
      case 2:
        this.orderBy = 'Descending';
        break;
      default:
        this.orderBy = 'Ascending';
        break;
    }

    this.gameService.orderBy(this.orderBy).subscribe(data => {
      this.games = data;
    });
  }

}
