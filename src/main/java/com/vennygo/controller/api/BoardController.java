package com.vennygo.controller.api;

import com.vennygo.entity.Board;
import com.vennygo.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/{boardId}")
    public ResponseEntity<Board> getBoardByBoardId(@PathVariable Long boardId) {
        Optional<Board> board = boardService.getBoard(boardId);
        return board.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Board>> getBoards() {
        List<Board> boards = boardService.getBoards();
        return ResponseEntity.ok(boards);
    }

    @PostMapping
    public ResponseEntity<Board> createBoard(@RequestBody Board board) {
        Board createBoard = boardService.createBoard(board);
        return ResponseEntity.ok(createBoard);
    }

    @PutMapping("/{boardId}")
    public ResponseEntity<Board> updateBoard(@PathVariable Long boardId, @RequestBody Board boardDetail) {
        Board updateBoard = boardService.updateBoard(boardId, boardDetail);
        return ResponseEntity.ok(updateBoard);
    }

    @DeleteMapping("/{boardId}")
    public ResponseEntity<Board> deleteBoard(@PathVariable Long boardId) {
        boardService.deleteBoard(boardId);
        return ResponseEntity.noContent().build();
    }
}
