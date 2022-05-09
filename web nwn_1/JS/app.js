// ANIMACIO DE LES TRES BARRES
const navSlide = () => {
    const burger = document.querySelector('.burger');
    const nav = document.querySelector('.nav-links');
    const navLinks = document.querySelectorAll('.nav-links li');

    burger.addEventListener('click', () => {
        // Tocar ara
        nav.classList.toggle('nav-active');

        // Links de animacio
        navLinks.forEach((link, index) => {
            if (link.style.animation) {
                link.style.animation = '';
            } else {
                link.style.animation = `navLinkFade 0.5s ease forwards ${index / 7 + 1}s`;
            }
        });
        // Animacio de el burger
        burger.classList.toggle('toggle');
    });
}

navSlide();