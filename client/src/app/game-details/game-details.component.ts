import { Component, OnInit, OnDestroy } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {GameService} from '../shared/game/game.service';
import {Subscription} from 'rxjs/Subscription';
import {PlatformService} from '../shared/platform/platform.service';

@Component({
  selector: 'app-game-details',
  templateUrl: './game-details.component.html',
  styleUrls: ['./game-details.component.scss']
})
export class GameDetailsComponent implements OnInit, OnDestroy {
  game: any = {};
  platform: any = {};
  sub: Subscription;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private gameService: GameService,
              private platformService: PlatformService) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if (id) {
        this.gameService.get(id).subscribe((game: any) => {
          if (game) {
            this.game = game;
            this.game.href = game._links.self.href;
            this.game.id = id;
            console.log(this.game.platform);
            this.platformService.getByName(this.game.platform).subscribe((platform: any) => {
              console.log(platform);
              this.platform = platform[0];
              console.log(this.platform.platformLogotypePath);
            });
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

  getIterator(number: number): Iterable<any> {
    const result = new Array<number>();
    for (let i = number - 1; i >= 0; i--) {
      result[i] = 1;
    }
    return result;
  }

}
