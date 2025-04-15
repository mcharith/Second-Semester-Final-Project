const seatBoxes = document.querySelectorAll('.box');
const selectedSeatLabel = document.getElementById('selected-seat');

const selectedSeats = new Set(); // store selected seat numbers

seatBoxes.forEach(box => {
    box.addEventListener('click', () => {
        const seatNumber = box.textContent.trim();
        if (seatNumber !== 'N/A' && seatNumber !== '') {
            if (box.classList.contains('selected')) {
                box.classList.remove('selected');
                selectedSeats.delete(seatNumber);
            } else {
                box.classList.add('selected');
                selectedSeats.add(seatNumber);
            }

            // Update the label
            if (selectedSeats.size > 0) {
                selectedSeatLabel.textContent = `Selected Seat(s): ${Array.from(selectedSeats).join(', ')}`;
            } else {
                selectedSeatLabel.textContent = '';
            }
        }
    });
});