document.addEventListener('DOMContentLoaded', async () => {
    const canvas = document.getElementById('pozicioChart');
    if (!canvas) return;

    const ctx = canvas.getContext('2d');

    try {
        const response = await fetch('/api/diagramdata');

        if (!response.ok) {
            throw new Error('HTTP hiba: ' + response.status);
        }

        const data = await response.json();

        const labels = Object.keys(data);
        const values = Object.values(data).map(v => Number(v));

        new Chart(ctx, {
            type: 'pie',
            data: {
                labels: labels,
                datasets: [
                    {
                        data: values
                    }
                ]
            },
            options: {
                responsive: true,
                plugins: {
                    legend: {
                        position: 'bottom'
                    },
                    tooltip: {
                        callbacks: {
                            label: function (ctx) {
                                const label = ctx.label || '';
                                const value = ctx.parsed;
                                return `${label}: ${value}%`;
                            }
                        }
                    }
                }
            }
        });

    } catch (err) {
        console.error('Hiba a diagram adatainak betöltésekor:', err);
    }
});
