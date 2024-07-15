package io.nology.drawn_together_backend.game;

import io.nology.drawn_together_backend.user.UserAuth;
import jakarta.persistence.*;

@Entity
@Table(name = "games")
public class Game {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long gameId;

  @ManyToOne
  @JoinColumn(name = "player1_id", nullable = false)
  private UserAuth player1;

  @ManyToOne
  @JoinColumn(name = "player2_id", nullable = false)
  private UserAuth player2;

  @Column(nullable = false)
  private int score;

  public Long getGameId() {
    return gameId;
  }

  public void setGameId(Long gameId) {
    this.gameId = gameId;
  }

  public UserAuth getPlayer1() {
    return player1;
  }

  public void setPlayer1(UserAuth player1) {
    this.player1 = player1;
  }

  public UserAuth getPlayer2() {
    return player2;
  }

  public void setPlayer2(UserAuth player2) {
    this.player2 = player2;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }
}
