package com.vennygo.controller.api;

import com.vennygo.entity.Board;
import com.vennygo.service.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
@Tag(name = "board")
public class BoardController {

    private final BoardService boardService;

    @Operation(summary = "게시판 조회 by boardId", description = "특정 게시판을 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Board.class))),
            @ApiResponse(responseCode = "404", description = "찾을 수 없음")
    })
    @GetMapping("/{boardId}")
    public ResponseEntity<Board> getBoardByBoardId(
            @Parameter(description = "게시판 ID", required = true) @PathVariable Long boardId) {
        Optional<Board> board = boardService.getBoard(boardId);
        return board.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "게시판 목록 조회", description = "전체 게시판 목록을 조회합니다.")
    @ApiResponse(responseCode = "200", description = "성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Board.class)))
    @GetMapping
    public ResponseEntity<List<Board>> getBoards() {
        List<Board> boards = boardService.getBoards();
        return ResponseEntity.ok(boards);
    }

    @Operation(summary = "게시판 생성", description = "새로운 게시판을 생성합니다.")
    @ApiResponse(responseCode = "200", description = "성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Board.class)))
    @PostMapping
    public ResponseEntity<Board> createBoard(
            @Parameter(description = "생성 할 게시판 정보", required = true) @RequestBody Board board) {
        Board createBoard = boardService.createBoard(board);
        return ResponseEntity.ok(createBoard);
    }

    @Operation(summary = "게시판 수정", description = "기존 게시판 정보를 수정합니다.")
    @ApiResponse(responseCode = "200", description = "성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Board.class)))
    @PutMapping("/{boardId}")
    public ResponseEntity<Board> updateBoard(
            @Parameter(description = "수정 할 게시판 ID", required = true) @PathVariable Long boardId,
            @Parameter(description = "수정 할 게시판 정보", required = true) @RequestBody Board boardDetail) {
        Board updateBoard = boardService.updateBoard(boardId, boardDetail);
        return ResponseEntity.ok(updateBoard);
    }

    @Operation(summary = "게시판 삭제", description = "특정 게시판을 삭제합니다.")
    @ApiResponse(responseCode = "204", description = "삭제 성공")
    @ApiResponse
    @DeleteMapping("/{boardId}")
    public ResponseEntity<Board> deleteBoard(
            @Parameter(description = "삭제 할 게시판 ID", required = true) @PathVariable Long boardId) {
        boardService.deleteBoard(boardId);
        return ResponseEntity.noContent().build();
    }
}
