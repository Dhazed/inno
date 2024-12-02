/** @type {import('tailwindcss').Config} */
module.exports = {
  corePlugins:{ preflight: false},
  content: [
    "./src/**/*.{html,ts}",
  ],
  theme: {
    extend: {
      colors: {
        'ic1-primary': '#006F98',
        'ic1-primary-dark': '#165874',
        'ic1-secondary': '#0B2E4F',
        'ic1-secondary-light': '#3C5872',
        'ic1-secondary-dark': '##1D2D3D',
        'ic1-gray': '#EDEFF0',
        'ic1-gray-light': '#C2D1D9',
      },
    },
  },
  plugins: [],
}

