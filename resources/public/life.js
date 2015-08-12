(function() {
  var forgeryToken = document.getElementById('__anti-forgery-token');
  var outputArea = document.getElementById('life-container');
  var startButton = document.getElementById('start-button');

  var allLifeCells = document.getElementsByClassName('life-cell');
  for (var i=0,len=allLifeCells.length;i<len;i++) {
    allLifeCells[i].addEventListener('click', function(e) {
      this.classList.toggle('alive');
    });
  }

  function getBoard() {
    var board = [];
    var lifeRows = document.getElementsByClassName('life');
    for (var i=0,len=lifeRows.length;i<len;i++) {
      var cells = [];
      var lifeCells = lifeRows[i].getElementsByClassName('life-cell');
      for (var j=0,len2=lifeCells.length;j<len2;j++) {
        if (lifeCells[j].classList.contains('alive')) {
          cells.push(1);
        } else {
          cells.push(0);
        }
      }
      board.push(cells);
    }
    return board;
  }

  startButton.addEventListener('click', function() {
    this.classList.add('hide');
    window.setInterval(function() {
      var request = new XMLHttpRequest();
      request.onreadystatechange = function() {
        if (request.readyState === 4 && request.status === 200) {
          outputArea.innerHTML = request.responseText;
        }
      }
      request.open('POST', '', true);
      request.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
      var board = getBoard();
      var forgeryValue = forgeryToken.value;
      var data = '__anti-forgery-token=' + encodeURIComponent(forgeryValue) + '&' + 'board=' + encodeURIComponent(JSON.stringify(board));
      request.send(data);
    }, 500);
  });
})();
