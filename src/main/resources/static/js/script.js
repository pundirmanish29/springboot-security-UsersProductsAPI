let slideIndex = 0;

function moveSlide(step) {
    const slides = document.getElementsByClassName("carousel-slide")[0];
    const totalSlides = slides.children.length;

    slideIndex = (slideIndex + step + totalSlides) % totalSlides;
    slides.style.transform = `translateX(-${slideIndex * 100}%)`;
}
