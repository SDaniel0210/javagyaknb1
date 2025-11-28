document.addEventListener("DOMContentLoaded", () => {

    const overlay = document.getElementById("overlay");
    const openBtn = document.getElementById("openOverlay");
    const closeBtn = document.getElementById("closeOverlay");

    const form = document.getElementById("jatekosForm");
    const title = document.getElementById("overlayTitle");

    // ÚJ JÁTÉKOS
    openBtn.addEventListener("click", () => {
        title.textContent = "Új játékos hozzáadása";
        form.action = "/NN8T44-gy/crud";
        form.reset();
        overlay.style.display = "flex";
    });

    // BEZÁRÁS
    closeBtn.addEventListener("click", () => {
        overlay.style.display = "none";
    });

    // SZERKESZTÉS
    document.querySelectorAll(".szerkeszt-btn").forEach(btn => {
        btn.addEventListener("click", () => {
            title.textContent = "Játékos szerkesztése";

            const id = btn.dataset.id;
            form.action = `/NN8T44-gy/crud/${id}/update`;

            // mezők feltöltése
            document.getElementById("nevInput").value = btn.dataset.nev;
            document.getElementById("mezInput").value = btn.dataset.mezszam;
            document.getElementById("posztInput").value = btn.dataset.poszt;
            document.getElementById("csapatInput").value = btn.dataset.csapat;
            document.getElementById("ertekInput").value = btn.dataset.ertek;
            document.getElementById("korInput").value = btn.dataset.kor;

            overlay.style.display = "flex";
        });
    });

});
