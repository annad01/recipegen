import { minifyHtml, injectHtml } from 'vite-plugin-html'

const scalaVersion = '2.13'

export default ({mode}) => {
    //const mainJS = `/target/scala-${scalaVersion}/root-${mode === 'production' ? 'opt' : 'fastopt'}/main.js`
    const mainJS = `/target/scala-${scalaVersion}/root-fastopt/main.js`
    const script = `<script type="module" src="${mainJS}"></script>`

    return {
        publicDir: './src/main/static/public',
        plugins: [
        ...(process.env.NODE_ENV === 'production' ? [
            minifyHtml(),
        ] : []),
        injectHtml({
            injectData: {
            script
            }
        })
        ]
    }
}