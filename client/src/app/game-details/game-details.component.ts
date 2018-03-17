import { Component, OnInit, OnDestroy } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {GameService} from '../shared/game.service';
import {Subscription} from 'rxjs/Subscription';

@Component({
  selector: 'app-game-details',
  templateUrl: './game-details.component.html',
  styleUrls: ['./game-details.component.scss']
})
export class GameDetailsComponent implements OnInit, OnDestroy {
  game: any = {};
  sub: Subscription;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private gameService: GameService) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if (id) {
        this.gameService.get(id).subscribe((game: any) => {
          if (game) {
            this.game = game;
            this.game.href = game._links.self.href;
            this.game.id = id;
          } else {
            console.log(`Game with id '${id}' not found, returning to list`);
            this.gotoList();
          }
        });
      }
    });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  gotoList() {
    this.router.navigate(['/game-list']);
  }

}
